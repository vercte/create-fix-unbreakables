package net.vercte.create_fix_unbreakables.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.kinetics.deployer.ManualApplicationRecipe;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ManualApplicationRecipe.class)
public class ManualApplicationRecipeMixin {
    @ModifyExpressionValue(method = "manualApplicationRecipesApplyInWorld", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;isDamageableItem()Z"))
    private static boolean onlyIfMaxDamage(boolean original, @Local ItemStack heldItem) {
        return heldItem.getMaxDamage() > 0;
    }
}
