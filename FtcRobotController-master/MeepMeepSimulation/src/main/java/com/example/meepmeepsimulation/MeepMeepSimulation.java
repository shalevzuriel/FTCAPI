package com.example.meepmeepsimulation;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.ColorScheme;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedDark;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepSimulation {
    public static void main(String args[])
    {
        MeepMeep meepMeep = new MeepMeep(700);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                //setting bot constraints
                // current values are not right since the robot isnt tuned. They are just for testing
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-35, -58, Math.toRadians(90)))
                                .lineTo(new Vector2d(-35, -35))
                                .lineTo(new Vector2d(-35, -12.666))
                                .lineTo(new Vector2d(46.666, -12.333))
                                .turn(Math.toRadians(90))
                                .lineTo(new Vector2d(46.666, -35))
                                .lineTo(new Vector2d(-58, -35))
                                .build()
                );
        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}