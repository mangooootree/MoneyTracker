package com.osipov.moneytracker;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Record> records = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        createRecords();
        recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ItemListAdapter());

    }

    private void createRecords() {
        records.add(new Record("Хлеб", 3));
        records.add(new Record("Сыр", 43445));
        records.add(new Record("Масло", 5));
        records.add(new Record("Мед", 5));
        records.add(new Record("Мясо", 10));
        records.add(new Record("Рыба", 6555));
        records.add(new Record("Колбаса", 93));
        records.add(new Record("Сосиски", 444));
        records.add(new Record("Пиво", 2));
        records.add(new Record("Яйца", 2));
    }

    private class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.RecordViewHolder> {
        @NonNull
        @Override
        public RecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_record,parent,false);
            return new RecordViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecordViewHolder holder, int position) {
            Record record = records.get(position);
            holder.applyData(record);
        }

        @Override
        public int getItemCount() {
            return records.size();
        }

        class RecordViewHolder extends RecyclerView.ViewHolder {
            private final TextView title;
            private final TextView price;

            RecordViewHolder(@NonNull View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.title);
                price = itemView.findViewById(R.id.price);
            }

            void applyData(Record record) {
                title.setText(record.getTitle());
                price.setText(String.valueOf(record.getPrice()));
            }
        }
    }
}
