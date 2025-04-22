package alex.tutorial.entity.client;

import alex.tutorial.entity.custom.TungEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;


public class TungRenderer extends MobEntityRenderer<TungEntity, TungRenderState, TungModel<TungRenderState>> {

    public TungRenderer(EntityRendererFactory.Context context) {
        super(context, new TungModel<TungRenderState>(context.getPart(TungModel.TUNG)),0.75f );
    }

    @Override
    public TungRenderState createRenderState() {
        return new TungRenderState();
    }

    private static final Identifier TEXTURE = Identifier.of("tutorial:textures/entity/tung/tung.png");

    @Override
    public Identifier getTexture(TungRenderState state) {
        return TEXTURE;
    }
}
