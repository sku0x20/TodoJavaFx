package sku.todo;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabase implements Database {

    private ArrayList<Item> items = new ArrayList<>();

    private Announcer<DatabaseListener> listeners = Announcer.to(DatabaseListener.class);

    @Override
    public void addItem(Item item) {
        items.add(item);
        notifyDataChanged();
    }

    @Override
    public List<Item> getItems() {
        return items;
    }

    @Override
    public void addListener(DatabaseListener listener) {
        listeners.addListener(listener);
    }

    @Override
    public void notifyDataChanged() {
        listeners.announce().dataChanged();
    }
}
