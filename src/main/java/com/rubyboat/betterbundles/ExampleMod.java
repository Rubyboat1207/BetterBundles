package com.rubyboat.betterbundles;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("modid");
	public static final String MOD_ID = "rb_betterbundles";
	public static final DyeableBundleItem LEATHER_BUNDLE = new DyeableBundleItem(new FabricItemSettings().group(ItemGroup.TOOLS).maxCount(1));
	public static final CustomizableBundleItem GOLD_BUNDLE = new CustomizableBundleItem(new FabricItemSettings().group(ItemGroup.TOOLS).maxCount(1));
	public static final CustomizableBundleItem DIAMOND_BUNDLE = new CustomizableBundleItem(new FabricItemSettings().group(ItemGroup.TOOLS).maxCount(1));
	public static final CustomizableBundleItem NETHERITE_BUNDLE = new CustomizableBundleItem(new FabricItemSettings().group(ItemGroup.TOOLS).maxCount(1).fireproof());

	@Override
	public void onInitialize() {
		LEATHER_BUNDLE.maxStorage = 64;
		GOLD_BUNDLE.maxStorage = 128;
		DIAMOND_BUNDLE.maxStorage = 64 * 3;
		NETHERITE_BUNDLE.maxStorage = 64 * 4;
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> LEATHER_BUNDLE.getColor(stack), LEATHER_BUNDLE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "leather_bundle"), LEATHER_BUNDLE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "golden_bundle"), GOLD_BUNDLE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "diamond_bundle"), DIAMOND_BUNDLE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "netherite_bundle"), NETHERITE_BUNDLE);

		LOGGER.info("Hello Fabric world!");
	}
}
