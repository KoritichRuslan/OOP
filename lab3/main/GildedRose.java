package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.getName().equals("Aged Brie")
                || item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.getSellIn() < 50) {
                        Item.increaseQualityByOne(item);

                        if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                            if (item.getSellIn() < 11) {
                                Item.increaseQualityByOne(item);
                            }

                            if (item.getSellIn() < 6) {
                                Item.increaseQualityByOne(item);
                            }
                        }
                    }
                } else if (!item.getName().equals("Sulfuras, Hand of Ragnaros")) {
                    Item.decreaseQualityByOne(item);
            }

            if (!item.getName().equals("Sulfuras, Hand of Ragnaros")) {
                item.setSellIn(item.getSellIn() - 1);
            }

            switch (item.getName()) {
                case "Aged Brie":
                    if (item.getSellIn() < 0) {
                        Item.increaseQualityByOne(item);
                    }
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    if (item.getSellIn() < 0) {
                        item.setQuality(0);
                    }
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    if (item.getSellIn() < 0) {
                        Item.decreaseQualityByOne(item);
                    }
                    break;
            }
        }
    }
}
