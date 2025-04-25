package alex.tutorial;

import alex.tutorial.entity.ModEntities;
import alex.tutorial.entity.client.TralaleroModel;
import alex.tutorial.entity.client.TralaleroRenderer;
import alex.tutorial.entity.client.TungModel;
import alex.tutorial.entity.client.TungRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class TutorialClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(TungModel.TUNG, TungModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.TUNG, TungRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(TralaleroModel.TRALALERO, TralaleroModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.TRALALERO, TralaleroRenderer::new);
    }
}
