package com.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;

public class ExampleMod implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {
        // Feather Client Tarzı Ekrana Canlı Çizim Sistemi (Mobil Uyumlu)
        HudRenderCallback.EVENT.register((drawContext, tickCounter) -> {
            MinecraftClient client = MinecraftClient.getInstance();
            
            // F1'e (veya arayüz gizleme tuşuna) basıldıysa yazıları gizle
            if (client.options.hudHidden) return;

            // Yazdırılacak Metinler
            String clientName = "NovaClient [Feather Edition]";
            String fpsText = "FPS: " + client.getCurrentFps();

            // drawText(Yazı Tipi, Metin, X ekseni, Y ekseni, Renk Kodu, Gölge)
            drawContext.drawText(client.textRenderer, clientName, 5, 5, 0x00FF00, true); // Yeşil renk
            drawContext.drawText(client.textRenderer, fpsText, 5, 15, 0xFFFFFF, true);   // Beyaz renk
        });
    }
}
