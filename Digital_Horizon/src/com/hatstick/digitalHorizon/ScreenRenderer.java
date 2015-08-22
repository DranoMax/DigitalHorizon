package com.hatstick.digitalHorizon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeBitmapFontData;
import com.hatstick.digitalHorizon.text.DialogueReader;

public class ScreenRenderer {
	
	private SpriteBatch spriteBatch;
	private BitmapFont[] font = new BitmapFont[4];
	private int fontCount = 0;
	private DialogueReader dialogueReader;
	
	public ScreenRenderer(DialogueReader dialogueReader) {
		this.dialogueReader = dialogueReader;
		dialogueReader.run();
		loadTextures();
	}

	private void loadTextures() {
		spriteBatch = new SpriteBatch();
		// Prepare our font
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("data/carbon bl.ttf"));
		font[0] = generator.generateFont(20);
		generator = new FreeTypeFontGenerator(Gdx.files.internal("data/ethnocentric rg.ttf"));
		font[1] = generator.generateFont(20);
		generator = new FreeTypeFontGenerator(Gdx.files.internal("data/Hyperspace.ttf"));
		font[2] = generator.generateFont(20);
		generator = new FreeTypeFontGenerator(Gdx.files.internal("data/space age.ttf"));
		font[3] = generator.generateFont(20);
		generator.dispose();
	}
	
	public void render() {
		spriteBatch.begin();
		font[fontCount].draw(spriteBatch, "Hello", 0, Gdx.graphics.getHeight());
		spriteBatch.end();
	}
	
	public void changeFontRight() {
		if (fontCount < font.length-1) {
			fontCount++;
		}
		else
			fontCount = 0;
	}
	
	public void changeFontLeft() {
		if (fontCount > 0) {
			fontCount--;
		}
		else
			fontCount = font.length-1;
	}
}
