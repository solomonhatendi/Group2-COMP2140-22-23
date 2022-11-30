import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> itemsList;
    public Inventory(){
        this.itemsList = new ArrayList<Item>();
    }

    public ArrayList<Item> getItemsList() {
        return itemsList;
    }

    public void setItems(ArrayList<Item> itemsList) {
        this.itemsList = itemsList;
    }

    public void addItem(Item item){
        itemsList.add(item);
    }

    public void removeItem(String UPC){
        Item itemToRemove = new Item();
        if(itemsList.size() != 0){
            for(Item i: itemsList){
                if(i.getUPC() == UPC){
                    itemToRemove = i;
                }
                itemsList.remove(itemToRemove);
            }
        }
    }

    public void removeItems(ArrayList<Item> itemsToRemove){
        for(Item i: itemsToRemove){
            itemsList.remove(i);
        }
    }


    public Item getItem(String UPC){
        Item itemToReturn = new Item();
        if(itemsList.size() != 0){
            for(Item i: itemsList){
                if(i.getUPC() == UPC){
                    itemToReturn = i;
                }
            }
        }
        return itemToReturn;
    }

    public String toString(){
        String str = "";
        for(Item i: itemsList){
            str += i; 
        }
        return str;
    }



}
