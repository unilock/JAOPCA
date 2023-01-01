package thelm.jaopca;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import thelm.jaopca.events.CommonEventHandler;

@Mod(
		modid = JAOPCA.MOD_ID,
		name = JAOPCA.NAME,
		version = JAOPCA.VERSION,
		dependencies = JAOPCA.DEPENDENCIES
		)
public class JAOPCA {

	public static final String MOD_ID = "jaopca";
	public static final String NAME = "JAOPCA";
	public static final String VERSION = "1.12.2-2.3.2.2";
	public static final String DEPENDENCIES = "required-before:wrapup";
	@Instance(JAOPCA.MOD_ID)
	public static JAOPCA core;
	@SidedProxy(
			clientSide = "thelm.jaopca.client.events.ClientEventHandler",
			serverSide = "thelm.jaopca.events.CommonEventHandler",
			modId = JAOPCA.MOD_ID)
	public static CommonEventHandler eventHandler;
	public static ModMetadata metadata;

	static {
		FluidRegistry.enableUniversalBucket();
	}

	@EventHandler
	public void onPreInit(FMLPreInitializationEvent event) {
		metadata = event.getModMetadata();
		metadata.autogenerated = false;
		metadata.version = VERSION;
		metadata.credits = "Idea taken from AOBD by ganymedes01";
		metadata.authorList.add("TheLMiffy1111");
		metadata.description = "A mod that aims to make mods with ore processing support more ores.";

		MinecraftForge.EVENT_BUS.register(eventHandler);
		eventHandler.onPreInit(event);
	}

	@EventHandler
	public void onInit(FMLInitializationEvent event) {
		eventHandler.onInit(event);
	}
}
