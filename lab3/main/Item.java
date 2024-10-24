package com.gildedrose;

public class Item {

    private String name;

    private int sellIn;

    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public static void increaseQualityByOne(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    public static void decreaseQualityByOne(Item item) {
        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 1);
        }
    }

    static void updateQuality(Item item) {
        decreaseQualityByOne(item);
        item.setSellIn(item.getSellIn() - 1);
        if (item.getSellIn() < 0) {
            decreaseQualityByOne(item);
        }
    }

    public void setSellIn(int sellIn) { this.sellIn = sellIn; }

    public void setQuality(int quality) { this.quality = quality; }

    public String getName() { return name; }

    public int getSellIn() { return sellIn; }

    public int getQuality() { return quality; }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
