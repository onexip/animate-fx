/*
 * Copyright (c) 2018 onexip GmbH. www.onexip.com
 */

package com.onexip.animatefx.test;

import com.onexip.animatefx.transitions.CachedTimelineTransition;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class TestButton extends Button {
    private CachedTimelineTransition transition;

    public TestButton(Class<? extends CachedTimelineTransition> transition) {
        super(transition.getSimpleName().replace("Transition", ""));


        try {
            this.transition = transition.getConstructor(Node.class).newInstance(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setOnMouseClicked((e) -> startTransition());
    }

    private void startTransition() {
        this.transition.play();
    }
}
