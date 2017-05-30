package eyeq.groove.event;

import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GrooveEventHandler {
    @SubscribeEvent
    public void onRenderLivingPre(RenderLivingEvent.Pre event) {
        RenderLivingBase render = event.getRenderer();
        ModelBase model = render.getMainModel();
        ModelRenderer head;
        ModelRenderer headWear = null;
        ModelRenderer arms = null;
        ModelRenderer rightArm = null;
        ModelRenderer leftArm = null;
        if(model instanceof ModelBiped) {
            head = ((ModelBiped) model).bipedHead;
            headWear = ((ModelBiped) model).bipedHeadwear;
            rightArm = ((ModelBiped) model).bipedRightArm;
            leftArm = ((ModelBiped) model).bipedLeftArm;
        } else if(model instanceof ModelVillager) {
            head = ((ModelVillager) model).villagerHead;
            arms = ((ModelVillager) model).villagerArms;
        } else if(model instanceof ModelIllager) {
            head = ((ModelIllager) model).head;
            arms = ((ModelIllager) model).arms;
            rightArm = ((ModelIllager) model).rightArm;
            leftArm = ((ModelIllager) model).leftArm;
        } else if(model instanceof ModelQuadruped) {
            head = ((ModelQuadruped) model).head;
        } else if(model instanceof ModelChicken) {
            head = ((ModelChicken) model).head;
        } else if(model instanceof ModelOcelot) {
            head = getHead(((ModelOcelot) model));
        } else if(model instanceof ModelRabbit) {
            head = getHead(((ModelRabbit) model));
        } else if(model instanceof ModelWolf) {
            head = ((ModelWolf) model).wolfHeadMain;
        } else if(model instanceof ModelHorse) {
            head = getHead(((ModelHorse) model));
        } else if(model instanceof ModelCreeper) {
            head = ((ModelCreeper) model).head;
        } else {
            return;
        }
        EntityLivingBase entity = event.getEntity();
        long now = System.currentTimeMillis() + entity.getUniqueID().hashCode();
        float t = (now / 4 % 360) * (float) Math.PI / 180;
        float offsetY = -Math.abs(MathHelper.sin(t) / 40);
        float offsetX = MathHelper.sin(t) / 10;
        if(head != null) {
            head.offsetY = offsetY;
            head.offsetX = offsetX;
        }
        if(headWear != null) {
            headWear.offsetY = offsetY;
            headWear.offsetX = offsetX;
        }
        if(arms != null) {
            arms.offsetX = offsetX / 2;
        }
        if(rightArm != null) {
            rightArm.offsetX = offsetX / 2;
        }
        if(leftArm != null) {
            leftArm.offsetX = offsetX / 2;
        }
    }

    public static ModelRenderer getHead(ModelOcelot model) {
        return ObfuscationReflectionHelper.getPrivateValue(ModelOcelot.class, model, "ocelotHead", "field_78156_g");
    }

    public static ModelRenderer getHead(ModelRabbit model) {
        return ObfuscationReflectionHelper.getPrivateValue(ModelRabbit.class, model, "rabbitHead", "field_178704_h");
    }

    public static ModelRenderer getHead(ModelHorse model) {
        return ObfuscationReflectionHelper.getPrivateValue(ModelHorse.class, model, "head", "field_110709_a");
    }
}
