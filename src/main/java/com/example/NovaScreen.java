package com.example;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class NovaScreen extends Screen {
    public NovaScreen() { super(Text.literal("NovaClient GUI")); }

    @Override
    protected void init() {
        int cx = this.width / 2;
        int cy = this.height / 2;

        this.addDrawableChild(ButtonWidget.builder(Text.literal("§eHUD Düzenleyici (Sürükle / Bırak)"), b -> {
            MinecraftClient.getInstance().setScreen(new HudEditorScreen());
        }).dimensions(cx - 100, cy - 20, 200, 20).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        context.fill(0, 0, this.width, this.height, 0x80000000);
        context.drawCenteredTextWithShadow(this.textRenderer, "FEATHER CLIENT", this.width / 2, this.height / 2 - 50, 0xFFFFFF);
        super.render(context, mouseX, mouseY, delta);
    }

    public static class HudEditorScreen extends Screen {
        public HudEditorScreen() { super(Text.literal("HUD Editor")); }
    }
}
