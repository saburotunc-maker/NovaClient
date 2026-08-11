package com.example;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class NovaScreen extends Screen {

    public NovaScreen() {
        super(Text.literal("NovaClient Menu"));
    }

    @Override
    protected void init() {
        int cx = this.width / 2;
        int cy = this.height / 2;

        this.addDrawableChild(ButtonWidget.builder(Text.literal("HUD Duzenleyici"), b -> {
            if (this.client != null) {
                this.client.setScreen(new HudEditorScreen());
            }
        }).dimensions(cx - 100, cy - 10, 200, 20).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, "FEATHER CLIENT", this.width / 2, this.height / 2 - 50, 0xFFFFFF);
    }

    public static class HudEditorScreen extends Screen {
        public HudEditorScreen() {
            super(Text.literal("HUD Editor"));
        }

        @Override
        public void render(DrawContext context, int mouseX, int mouseY, float delta) {
            super.render(context, mouseX, mouseY, delta);
            context.drawCenteredTextWithShadow(this.textRenderer, "HUD Duzenleyici (Sürukle & Birak)", this.width / 2, this.height / 2, 0x00FF00);
        }
    }
}
