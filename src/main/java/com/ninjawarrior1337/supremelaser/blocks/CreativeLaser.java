package com.ninjawarrior1337.supremelaser.blocks;

import buildcraft.silicon.BlockLaser;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by ninjawarrior1337 on 4/23/2017.
 */
public class CreativeLaser extends BlockLaser
{
    public CreativeLaser()
        {
            this.setBlockTextureName("creative_laser");
        }

        @Override
        public TileEntity createNewTileEntity(World world, int metadata)
        {
            return new TileCreativeLaser();
        }
}
