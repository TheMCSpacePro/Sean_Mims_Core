package com.themcspacepro.smcore;

import com.themcspacepro.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Proxy;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION, dependencies = "required-after:Forge[14.23.5.2768]", useMetadata = true)
public class Main
{
    public static final String MODID = "smcore";
    public static final String NAME = "Sean Mims Core";
    public static final String VERSION = "1.0";

    @SidedProxy(clientSide = "com.themcspacepro.proxy.ClientProxy", serverSide = "com.themcspacepro.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static Proxy instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}