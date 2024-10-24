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

    public void increaseQualityByOne() {
        if (getQuality() < 50) {
            setQuality(getQuality() + 1);
        }
    }

    public void decreaseQualityByOne() {
        if (getQuality() > 0) {
            setQuality(getQuality() - 1);
        }
    }

    public void updateQuality() {
        decreaseQualityByOne();
        setSellIn(getSellIn() - 1);
        if (getSellIn() < 0) {
            decreaseQualityByOne();
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
