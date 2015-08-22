package com.hatstick.digitalHorizon;

import com.badlogic.gdx.Game;
import com.hatstick.digitalHorizon.screen.TestScreen;

public class DigitalHorizon extends Game {

	@Override
	public void create() {
		setScreen(new TestScreen());
	}
}
