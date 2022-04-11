package com.teamcreeper.wordlemod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.teamcreeper.wordlemod.WordleMC;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordleScreen extends AbstractContainerScreen<WordleMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/wordleboard.png");
    private static final ResourceLocation A = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/a.png");
    private static final ResourceLocation B = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/b.png");
    private static final ResourceLocation C = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/c.png");
    private static final ResourceLocation D = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/d.png");
    private static final ResourceLocation E = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/e.png");
    private static final ResourceLocation F = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/f.png");
    private static final ResourceLocation G = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/g.png");
    private static final ResourceLocation H = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/h.png");
    private static final ResourceLocation I = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/i.png");
    private static final ResourceLocation J = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/j.png");
    private static final ResourceLocation K = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/k.png");
    private static final ResourceLocation L = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/l.png");
    private static final ResourceLocation M = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/m.png");
    private static final ResourceLocation N = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/n.png");
    private static final ResourceLocation O = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/o.png");
    private static final ResourceLocation P = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/p.png");
    private static final ResourceLocation Q = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/q.png");
    private static final ResourceLocation R = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/r.png");
    private static final ResourceLocation S = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/s.png");
    private static final ResourceLocation T = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/t.png");
    private static final ResourceLocation U = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/u.png");
    private static final ResourceLocation V = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/v.png");
    private static final ResourceLocation W = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/w.png");
    private static final ResourceLocation X = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/x.png");
    private static final ResourceLocation Y = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/y.png");
    private static final ResourceLocation Z = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/z.png");
    private static final ResourceLocation mid = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/middle.png");
    private static final ResourceLocation correct = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/correct.png");
    private static final ResourceLocation wrong = new ResourceLocation(WordleMC.MOD_ID, "textures/gui/wrong.png");

    //public ArrayList<String> word = new ArrayList<String>(5);
    public String [] word = new String[5];
    public int letterCounter = 0;
    public int newletter = 0;

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
    /*public static final String[] letters =  {String.valueOf(A), String.valueOf(B), String.valueOf(C), String.valueOf(D), String.valueOf(E),String.valueOf(F),String.valueOf(G),
            String.valueOf(H), String.valueOf(I), String.valueOf(J), String.valueOf(K), String.valueOf(L),String.valueOf(M),String.valueOf(N),
            String.valueOf(O), String.valueOf(P), String.valueOf(Q), String.valueOf(R), String.valueOf(S),String.valueOf(T),String.valueOf(U),
            String.valueOf(U), String.valueOf(V), String.valueOf(W), String.valueOf(X), String.valueOf(Y),String.valueOf(Z)
    };*/

    public Map<String, String> abc = new HashMap<String, String>() {{
        put("a", String.valueOf(A));
        put("b", String.valueOf(B));
        put("c", String.valueOf(C));
        put("d", String.valueOf(D));
        put("e", String.valueOf(E));
    }};

    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);

        int [][] positions = textureSlotsGenerator(this.leftPos,this.topPos);
        /*for (int i = 0; i < 25; ++i) {
            int xloc = positions[i][0];
            int yloc = positions[i][1];
            RenderSystem.setShaderTexture(0, ResourceLocation.tryParse(letters[i]));
            this.blit(pPoseStack, xloc, yloc ,0,0,20,20,20,20);
        }*/

        /*if(a != 0){
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
        }*/
        for(int g = 0;g< word.length;++g){
            if(word[g] != null){
                String letter = word[g];
                System.out.println(letter);
                System.out.println("String value of: "+  abc.get(letter));
                RenderSystem.setShaderTexture(0, ResourceLocation.tryParse(abc.get(letter)));
                int xloc = positions[g][0];
                int yloc = positions[g][1];
                this.blit(pPoseStack, xloc, yloc ,0,0,20,20,20,20);
            }
        }
        /*if(newletter != 0){
            for(int g = 0;g< word.length;++g){
                if(word[g] != null){
                    String letter = word[g];
                    System.out.println(letter);
                    System.out.println("String value of: "+  abc.get(letter));
                    RenderSystem.setShaderTexture(0, ResourceLocation.tryParse(abc.get(letter)));
                    int xloc = positions[g][0];
                    int yloc = positions[g][1];
                    this.blit(pPoseStack, xloc, yloc ,0,0,20,20,20,20);
                }
            }
            newletter = 0;
        }*/
    }
    /*public void textureDrawer(){

    }*/
    public int[][] textureSlotsGenerator(int x, int y){
        int[][] twoDIntArray = new int[30][2];
        int accumulator = 0;
        for (int i = 0; i < 6; ++i) {
            for (int l = 0; l < 5; ++l) {
                twoDIntArray[accumulator][0] = x + 32 + l*23;
                twoDIntArray[accumulator][1] = y + 32 + i*22;
                accumulator += 1;
            }
        }
        /*for (int i = 0; i < 30; ++i) {
            System.out.println(Arrays.toString(twoDIntArray[i]));
        }*/
        return twoDIntArray;
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
        if (typedChar == 'a' || typedChar == 'b' || typedChar == 'c' || typedChar == 'd' || typedChar == 'e'){
            word[letterCounter]= String.valueOf(typedChar);
            newletter = 1;
            letterCounter += 1;
            a = 1;
        }
        /*if (typedChar == 'a' || typedChar == 'A'){
            word[letterCounter]= String.valueOf(typedChar);
            newletter = 1;
            letterCounter += 1;
            a = 1;
        }
        if (typedChar == 'b' || typedChar == 'B'){
            b = 1;
        }
        if (typedChar == 'c' || typedChar == 'C'){
            c = 1;
        }
        if (typedChar == 'd' || typedChar == 'D'){
            d = 1;
        }
        if (typedChar == 'e' || typedChar == 'E'){
            e = 1;
        }*/
        if (typedChar == '1'){
            a = 0;
        }

        super.charTyped(typedChar, keyCode);
        return true;
    }
}
