package alex.tutorial.entity.client;

import alex.tutorial.entity.custom.TralaleroEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class TralaleroRenderer extends MobEntityRenderer<TralaleroEntity, TralaleroRenderState, TralaleroModel<TralaleroRenderState>> {

    public TralaleroRenderer(EntityRendererFactory.Context context) {
        super(context, new TralaleroModel<TralaleroRenderState>(context.getPart(TralaleroModel.TRALALERO)),0.75f );
    }

    @Override
    public TralaleroRenderState createRenderState() {
        return new TralaleroRenderState();
    }

    private static final Identifier TEXTURE = Identifier.of("tutorial:textures/entity/tralalero/tralalero.png");

    @Override
    public Identifier getTexture(TralaleroRenderState state) {
        return TEXTURE;
    }
}