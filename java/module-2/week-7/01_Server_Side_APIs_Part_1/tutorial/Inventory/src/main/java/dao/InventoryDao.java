package dao;

import model.Inventory;

import java.util.List;

public interface InventoryDao {

    Inventory getInventoryById(int inventoryId);

    List<Inventory> getInventory();

    Inventory createInventory(Inventory newInventory);

    Inventory updateInventory(Inventory updatedInventory);

    int deleteInventory(int inventoryId);
}
