/*
 * Copyright (c) 2018 onexip GmbH. www.onexip.com
 */

package com.onexip.animatefx.transitions;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.TimelineBuilder;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 * Animate a fade out effect on a node
 * <p>
 * Port of FadeOut from Animate.css http://daneden.me/animate by Dan Eden
 * <p>
 * {@literal @}keyframes fadeOut {
 * 0% {opacity: 1;}
 * 100% {opacity: 0;}
 * }
 *
 * @author Jasper Potts
 */
public class FadeOutTransition extends CachedTimelineTransition {
    /**
     * Create new FadeOutTransition
     *
     * @param node The node to affect
     */
    public FadeOutTransition(final Node node) {
        super(
                node,
                TimelineBuilder.create()
                        .keyFrames(
                                new KeyFrame(Duration.millis(0), new KeyValue(node.opacityProperty(), 1, WEB_EASE)),
                                new KeyFrame(Duration.millis(1000), new KeyValue(node.opacityProperty(), 0, WEB_EASE))
                        )
                        .build()
        );
        setCycleDuration(Duration.seconds(1));
        setDelay(Duration.seconds(0.2));
    }
}
