package net.vercte.create_fix_unbreakables.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.simibubi.create.content.kinetics.belt.behaviour.TransportedItemStackHandlerBehaviour;
import com.simibubi.create.content.kinetics.belt.transport.TransportedItemStack;
import com.simibubi.create.content.kinetics.deployer.BeltDeployerCallbacks;
import com.simibubi.create.content.kinetics.deployer.DeployerBlockEntity;
import net.minecraft.world.item.crafting.Recipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BeltDeployerCallbacks.class)
public class BeltDeployerCallbacksMixin {
    @ModifyExpressionValue(method = "activate", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;isDamageableItem()Z"))
    private static boolean onlyIfMaxDamage(boolean original, TransportedItemStack transported, TransportedItemStackHandlerBehaviour handler,
                                           DeployerBlockEntity blockEntity, Recipe<?> recipe) {
        return blockEntity.getPlayer().getMainHandItem().getMaxDamage() > 0;
    }
}
