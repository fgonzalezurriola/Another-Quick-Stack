package dev.fgonz.quickstack;

import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;

/**
 * Persisted settings for Quick Stack: search radius and which inventory sections to check.
 * 
 * Inventory sections:
 *   - Storage: Main inventory grid
 *   - Backpack: Expandable backpack slots
 *   - Hotbar: Quick access bar (usually excluded to avoid moving equipped items)
 */
public class QuickStackConfig {

    private int searchRadius;
    private boolean checkStorage;
    private boolean checkBackpack;
    private boolean checkHotbar;

    public static final BuilderCodec<QuickStackConfig> CODEC = BuilderCodec.builder(QuickStackConfig.class, QuickStackConfig::new)
        .append(new KeyedCodec<>("SearchRadius", Codec.INTEGER), QuickStackConfig::setSearchRadius, QuickStackConfig::getSearchRadius).add()
        .append(new KeyedCodec<>("CheckStorage", Codec.BOOLEAN), QuickStackConfig::setCheckStorage, QuickStackConfig::isCheckStorage).add()
        .append(new KeyedCodec<>("CheckBackpack", Codec.BOOLEAN), QuickStackConfig::setCheckBackpack, QuickStackConfig::isCheckBackpack).add()
        .append(new KeyedCodec<>("CheckHotbar", Codec.BOOLEAN), QuickStackConfig::setCheckHotbar, QuickStackConfig::isCheckHotbar).add()
        .build();

    public QuickStackConfig() {
        this.searchRadius = 5;
        this.checkStorage = true;
        this.checkBackpack = true;
        this.checkHotbar = false;
    }

    public int getSearchRadius() {
        return searchRadius;
    }

    public void setSearchRadius(int searchRadius) {
        this.searchRadius = searchRadius;
    }

    public boolean isCheckStorage() {
        return checkStorage;
    }

    public void setCheckStorage(boolean checkStorage) {
        this.checkStorage = checkStorage;
    }

    public boolean isCheckBackpack() {
        return checkBackpack;
    }

    public void setCheckBackpack(boolean checkBackpack) {
        this.checkBackpack = checkBackpack;
    }

    public boolean isCheckHotbar() {
        return checkHotbar;
    }

    public void setCheckHotbar(boolean checkHotbar) {
        this.checkHotbar = checkHotbar;
    }
}
