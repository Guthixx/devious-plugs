package net.runelite.client.plugins.nightmare.util.loadouts;

public class Loadout {
    private EquipmentLoadout equipmentLoadout;
    private InventoryLoadout inventoryLoadout;

    public Loadout(EquipmentLoadout equipmentLoadout, InventoryLoadout inventoryLoadout) {
        this.equipmentLoadout = equipmentLoadout;
        this.inventoryLoadout = inventoryLoadout;
    }


    public boolean fulfilled() {
        return (equipmentLoadout == null || equipmentLoadout.fulfilled())
                && (inventoryLoadout == null || inventoryLoadout.fulfilled());
    }

    public boolean fulfill() {
        if (equipmentLoadout != null && !equipmentLoadout.fulfilled()) {
            equipmentLoadout.fulfill();
            return false;
        } else if (inventoryLoadout != null && !inventoryLoadout.fulfilled()) {
            inventoryLoadout.fulfill();
            return false;
        }
        return true;
    }

    public void addInventoryItem(LoadoutItem item) {
        if (inventoryLoadout == null) {
            inventoryLoadout = new InventoryLoadout();
        }
        inventoryLoadout.addItem(item);
    }

    public void addEquipmentItem(LoadoutItem item) {
        if (equipmentLoadout == null) {
            equipmentLoadout = new EquipmentLoadout();
        }
        equipmentLoadout.addItem(item);
    }
}