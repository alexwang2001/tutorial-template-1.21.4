package alex.tutorial.entity.client;

import alex.tutorial.Tutorial;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.minecraft.util.Identifier;

public class TralaleroModel<T extends BipedEntityRenderState> extends EntityModel<TralaleroRenderState> {

    public static final EntityModelLayer TRALALERO = new EntityModelLayer(Identifier.of(Tutorial.MOD_ID, "tralalero"), "main");

    private final ModelPart head;
    private final ModelPart hat;
    private final ModelPart body;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;
    private final ModelPart rightArm;
    private final ModelPart leftArm;
    private final ModelPart fin;

    public TralaleroModel(ModelPart modelPart) {
        super(modelPart);
        this.head = modelPart.getChild(EntityModelPartNames.HEAD);
        this.hat = this.head.getChild(EntityModelPartNames.HAT);
        this.body = modelPart.getChild(EntityModelPartNames.BODY);
        this.fin = body.getChild("fin");
        this.rightArm = modelPart.getChild(EntityModelPartNames.RIGHT_ARM);
        this.leftArm = modelPart.getChild(EntityModelPartNames.LEFT_ARM);
        this.rightLeg = modelPart.getChild(EntityModelPartNames.RIGHT_LEG);
        this.leftLeg = modelPart.getChild(EntityModelPartNames.LEFT_LEG);
    }

    public static TexturedModelData getTexturedModelData() {

        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        ModelPartData modelPartData2 = modelPartData.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -8.0F, -14.0F, 12.0F, 11.0F, 19.0F, new Dilation(-1.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        modelPartData2.addChild(EntityModelPartNames.HAT, ModelPartBuilder.create().uv(32, 0).cuboid(-4.0F, -8.0F, -4.0F, 0F, 0F, 0F, new Dilation(0.0F)), ModelTransform.NONE);

        ModelPartData modelPartData3 = modelPartData.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0, 30).cuboid(-5.0F, -9.0F, -3.0F, 10.0F, 14.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 12.0F, 0.0F));

        modelPartData.addChild(EntityModelPartNames.RIGHT_ARM, ModelPartBuilder.create().uv(0, 50).cuboid(-1.0F, -1.0F, -2.0F, 2.0F, 10.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-7.0F, 8.0F, 0.0F));

        modelPartData.addChild(EntityModelPartNames.LEFT_ARM, ModelPartBuilder.create().uv(1, 50).cuboid(-1.0F, -1.0F, -2.0F, 2.0F, 10.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(7.0F, 8.0F, 0.0F));

        modelPartData.addChild(EntityModelPartNames.RIGHT_LEG, ModelPartBuilder.create().uv(40, 42).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new Dilation(0.0F))
                .uv(17, 52).cuboid(-2.0F, 3.0F, -6.0F, 4.0F, 4.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 17.0F, 0.0F));

        modelPartData.addChild(EntityModelPartNames.LEFT_LEG, ModelPartBuilder.create().uv(32, 42).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new Dilation(0.0F))
                .uv(17, 52).cuboid(-2.0F, 3.0F, -6.0F, 4.0F, 4.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, 17.0F, 0.0F));

        modelPartData3.addChild("fin", ModelPartBuilder.create().uv(15, 31).cuboid(-1.0F, -6.0373F, -2.1566F, 2.0F, 11.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.5712F, 1.1866F, -0.5672F, 0.0F, 0.0F));

        return TexturedModelData.of(modelData, 64, 64);

    }

}
