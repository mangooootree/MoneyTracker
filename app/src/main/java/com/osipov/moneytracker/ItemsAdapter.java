package com.osipov.moneytracker;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.RecordViewHolder> {

    private List<Item> items = new ArrayList<>();

    public void setData(List<Item> data) {
        createRecords();
        //this.items = data;
        notifyDataSetChanged();
    }

    public void addItem(Item item) {
        items.add(0, item);
        notifyItemInserted(0);
    }

    private void createRecords() {
        items.add(new Item("Хлеб", "3", Item.TYPE_EXPENSES));
        items.add(new Item("Сыр", "43445", Item.TYPE_EXPENSES));
        items.add(new Item("Масло", "5", Item.TYPE_EXPENSES));
        items.add(new Item("Мед", "5", Item.TYPE_EXPENSES));
        items.add(new Item("Мясо", "10", Item.TYPE_EXPENSES));
        items.add(new Item("Рыба", "6555", Item.TYPE_EXPENSES));
        items.add(new Item("Колбаса", "93", Item.TYPE_EXPENSES));
        items.add(new Item("Сосиски", "444", Item.TYPE_EXPENSES));
        items.add(new Item("Пиво", "2", Item.TYPE_EXPENSES));
        items.add(new Item("Яйца", "2", Item.TYPE_EXPENSES));
        items.add(new Item("Рыба", "6555", Item.TYPE_EXPENSES));
        items.add(new Item("Колбаса", "93", Item.TYPE_EXPENSES));
        items.add(new Item("Сосиски", "444", Item.TYPE_EXPENSES));
        items.add(new Item("Пиво", "2", Item.TYPE_EXPENSES));
    }

    @NonNull
    @Override
    public RecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new RecordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecordViewHolder holder, int position) {
        Item item = items.get(position);
        holder.applyData(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class RecordViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView price;

        RecordViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
        }

        void applyData(Item item) {
            title.setText(item.name);
            price.setText(item.price);
        }
    }
}
