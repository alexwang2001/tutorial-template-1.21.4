package alex.tutorial.entity.client;

import alex.tutorial.Tutorial;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.client.model.ModelPart;

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class TungModel<TungRenderState> extends BipedEntityModel<BipedEntityRenderState> {

	public static final EntityModelLayer TUNG = new EntityModelLayer(Identifier.of(Tutorial.MOD_ID, "tung"), "main");

	private final ModelPart head;
	private final ModelPart hat;
	private final ModelPart body;
	private final ModelPart rightLeg;
	private final ModelPart leftLeg;
	private final ModelPart rightArm;
	private final ModelPart leftArm;

	public TungModel(ModelPart modelPart) {
		super(modelPart);
		this.head = modelPart.getChild(EntityModelPartNames.HEAD);
		this.hat = this.head.getChild(EntityModelPartNames.HAT);
		this.body = modelPart.getChild(EntityModelPartNames.BODY);
		this.rightArm = modelPart.getChild(EntityModelPartNames.RIGHT_ARM);
		this.leftArm = modelPart.getChild(EntityModelPartNames.LEFT_ARM);
		this.rightLeg = modelPart.getChild(EntityModelPartNames.RIGHT_LEG);
		this.leftLeg = modelPart.getChild(EntityModelPartNames.LEFT_LEG);
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData modelPartData2 = modelPartData.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -7.0F, -4.0F, 12.0F, 14.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		modelPartData2.addChild(EntityModelPartNames.HAT, ModelPartBuilder.create().uv(32, 0).cuboid(-4.0F, -8.0F, -4.0F, 0F, 0F, 0F, new Dilation(0.0F)), ModelTransform.NONE);

		modelPartData.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(31, 46).cuboid(-5.0F, -5.0F, -3.0F, 10.0F, 10.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 12.0F, 0.0F));

		modelPartData.addChild(EntityModelPartNames.RIGHT_ARM, ModelPartBuilder.create().uv(0, 32).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-7.0F, 8.0F, 0.0F));

		modelPartData.addChild(EntityModelPartNames.LEFT_ARM, ModelPartBuilder.create().uv(8, 32).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(7.0F, 8.0F, 0.0F));

		modelPartData.addChild(EntityModelPartNames.RIGHT_LEG, ModelPartBuilder.create().uv(16, 32).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 17.0F, 0.0F));

		modelPartData.addChild(EntityModelPartNames.LEFT_LEG, ModelPartBuilder.create().uv(24, 32).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, 17.0F, 0.0F));

		return TexturedModelData.of(modelData, 128, 128);
	}

}