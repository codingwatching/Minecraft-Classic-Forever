package com.mojang.minecraft.level.tile;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.level.tile.Block;

public final class SlabBlock extends Block {

   private boolean doubleSlab;


   public SlabBlock(int var1, boolean var2) {
      super(var1, 6);
      this.doubleSlab = var2;
      if(!var2) {
         this.setBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      }

   }

   protected final int getTextureId(int var1) {
      return var1 <= 1?6:5;
   }

   public final boolean isSolid() {
      return this.doubleSlab;
   }

   public final void onNeighborChange(Level var1, int var2, int var3, int var4, int var5) {
      if(this == Block.SLAB) {
         ;
      }
   }

   public final void onAdded(Level var1, int var2, int var3, int var4) {
      if(this != Block.SLAB) {
         super.onAdded(var1, var2, var3, var4);
      }

      if(var1.getTile(var2, var3 - 1, var4) == SLAB.id) {
         var1.setTile(var2, var3, var4, 0);
         var1.setTile(var2, var3 - 1, var4, Block.DOUBLE_SLAB.id);
      }

   }

   public final int getDrop() {
      return Block.SLAB.id;
   }

   public final boolean isCube() {
      return this.doubleSlab;
   }

   public final boolean canRenderSide(Level var1, int var2, int var3, int var4, int var5) {
      if(this != Block.SLAB) {
         super.canRenderSide(var1, var2, var3, var4, var5);
      }

      return var5 == 1?true:(!super.canRenderSide(var1, var2, var3, var4, var5)?false:(var5 == 0?true:var1.getTile(var2, var3, var4) != this.id));
   }
}
