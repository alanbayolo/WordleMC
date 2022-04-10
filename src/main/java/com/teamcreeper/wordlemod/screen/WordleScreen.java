package com.teamcreeper.wordlemod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.teamcreeper.wordlemod.WordleMC;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.VK_BACK_SPACE;
import static java.awt.event.KeyEvent.VK_DELETE;

public class WordleScreen extends AbstractContainerScreen<WordleMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/wordleboard.png");
    private static final ResourceLocation A = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/a.png");
    private static final ResourceLocation B = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/b.png");
    private static final ResourceLocation C = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/c.png");
    private static final ResourceLocation D = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/d.png");
    private static final ResourceLocation E = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/e.png");
    private static final ResourceLocation mid = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/middle.png");

    public WordleScreen(WordleMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }
    public static int a = 0;public static int b = 0;public static int c = 0;public static int d = 0;public static int e = 0;
    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTicks, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    }
    public static final String[] letters =  {String.valueOf(A), String.valueOf(B), String.valueOf(C), String.valueOf(D), String.valueOf(E)};
    public static float typingPositions[][][];
    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);

        for (int i = 0; i < 6; ++i) {
            for (int l = 0; l < 5; ++l) {
                /*RenderSystem.setShaderTexture(0, mid);
                this.blit(pPoseStack, this.leftPos + 32 + (l*23), this.topPos  + 32 + (i*22) ,0,0,20,20,20,20);*/

                System.out.print("current pos X: " + this.leftPos + 32 + (l*23) + " current pos Y: " + this.topPos  + 32 + (i*22));
                RenderSystem.setShaderTexture(0, ResourceLocation.tryParse(letters[l]));
                this.blit(pPoseStack, this.leftPos + 32 + (l*23), this.topPos  + 32 + (i*22) ,0,0,20,20,20,20);


            }
        }

        if(a != 0){
            RenderSystem.setShaderTexture(0, mid);
            this.blit(pPoseStack, this.leftPos + 32, this.topPos  + 32,0,0,20,20,20,20);
            RenderSystem.setShaderTexture(0, D );
            this.blit(pPoseStack, this.leftPos + 32, this.topPos + 32,0,0,20,20,20,20);
        }
        if(b != 0){
            RenderSystem.setShaderTexture(0, mid);
            this.blit(pPoseStack, this.leftPos + 55, this.topPos  + 32,0,0,20,20,20,20);
            RenderSystem.setShaderTexture(0, D );
            this.blit(pPoseStack, this.leftPos + 55, this.topPos  + 32,0,0,20,20,20,20);
        }

    }
    public void TypingManager(){

    }
    public void typingRender(PoseStack pPoseStack,char typedChar){

    }

    //logic for adding the letters to an array every time a key is pressed 6x5
    //after entering the array it generates an object of letter
    //the object is then displayed
    //function to remove the objects for the lastest letter in the array with the press of backspace
    //function to execute the verification after pressing enter
    //function for changing the background of the letters depending of their existance and correct positioning

    @Override
    public boolean charTyped(char typedChar, int keyCode){
        //Pausing the game
        if (typedChar == 'a' || typedChar == 'A'){
            a = 1;
        }
        if (typedChar == 'b' || typedChar == 'B'){
            a = 0;
        }
        if (typedChar == '/'){
            a = 0;
        }

        super.charTyped(typedChar, keyCode);
        return true;
    }
}
