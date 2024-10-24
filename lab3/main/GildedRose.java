package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.getName()) {
                case "Aged Brie":
                    Item.increaseQualityByOne(item);
                    item.setSellIn(item.getSellIn() - 1);
                    if (item.getSellIn() < 0) {
                        Item.increaseQualityByOne(item);
                    }
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    Item.increaseQualityByOne(item);
                    if (item.getSellIn() < 6) {
                        Item.increaseQualityByOne(item);
                    }
                    if (item.getSellIn() < 11) {
                        Item.increaseQualityByOne(item);
                    }
                    item.setSellIn(item.getSellIn() - 1);
                    if (item.getSellIn() < 0) {
                        item.setQuality(0);
                    }
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    Item.decreaseQualityByOne(item);
                    item.setSellIn(item.getSellIn() - 1);
                    if (item.getSellIn() < 0) {
                        Item.decreaseQualityByOne(item);
                    }
                    break;
            }
        }
    }
}
