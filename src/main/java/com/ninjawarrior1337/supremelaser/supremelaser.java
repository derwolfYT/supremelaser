package com.ninjawarrior1337.supremelaser;

import buildcraft.silicon.BlockLaser;
import com.ninjawarrior1337.supremelaser.blocks.CreativeLaser;
import com.ninjawarrior1337.supremelaser.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

/**
 * Created by ninjawarrior1337 on 4/23/2017.
 */
@Mod(modid = reference.MOD_ID, version = reference.VERSION, name = reference.MOD_NAME, dependencies = "required-after:BuildCraft|Silicon")
public class supremelaser
{
    public static Block CreativeLaser;

    @Mod.Instance(reference.MOD_ID)
    public static supremelaser instance;

    @SidedProxy(clientSide = "com.ninjawarrior1337.supremelaser.proxy.ClientProxy", serverSide = "com.ninjawarrior1337.supremelaser.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
        proxy.preInit(e);
        CreativeLaser = new CreativeLaser().setBlockName("creative_laser");
        GameRegistry.registerBlock(CreativeLaser, CreativeLaser.getUnlocalizedName().substring(5));
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e)
    {
        proxy.init(e);
        GameRegistry.addShapelessRecipe(new ItemStack(new CreativeLaser(), 1), new Object[]{new ItemStack(new BlockLaser())});
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
        proxy.postInit(e);
    }
}
