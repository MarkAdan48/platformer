package com.adanm.platformer.Model;

import com.adanm.platformer.Controller.levelController;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

import javafx.scene.shape.Polyline;


public class Bodies {
    public static void createBody(MapObject mapObject) {
        String bodyType = mapObject.getProperties().get("type").toString();

        if (bodyType.equalsIgnoreCase("ground")) {
            PolylineMapObject polylineObject = (PolylineMapObject)mapObject;
            BodyDef bodyDefinition = new BodyDef();
            bodyDefinition.type = BodyDef.BodyType.StaticBody;
            bodyDefinition.position.set(polylineObject.getPolyline().getX() * levelController.UNIT_SCALE, polylineObject.getPolyline().getY() * levelController.UNIT_SCALE);

            Body physicsBody = levelController.gameWorld.createBody(bodyDefinition);
            ChainShape chainShape = new ChainShape();
            float[] transformedVertices = new float[polylineObject.getPolyline().getVertices().length];

            for (int index = 0; index < transformedVertices.length; index++) {
                transformedVertices[index] = polylineObject.getPolyline().getVertices()[index] * levelController.UNIT_SCALE;
            }

            chainShape.createChain(transformedVertices);

            FixtureDef fixtureDefinition = new FixtureDef();
            fixtureDefinition.shape = chainShape;

            physicsBody.createFixture(fixtureDefinition);
            chainShape.dispose();

        }

        else if (bodyType.equalsIgnoreCase("slope")) {
            PolygonMapObject polygonObject = (PolygonMapObject)mapObject;
            BodyDef bodyDefinition = new BodyDef();
            bodyDefinition.type = BodyDef.BodyType.StaticBody;
            bodyDefinition.position.set(polygonObject.getPolygon().getX() * levelController.UNIT_SCALE, polygonObject.getPolygon().getY() * levelController.UNIT_SCALE);

            Body physicsBody = levelController.gameWorld.createBody(bodyDefinition);
            PolygonShape slopeShape = new PolygonShape();

            float[] transformedVertices = new float[6];

            for (int index = 0; index < transformedVertices.length; index++) {
                transformedVertices[index] = polygonObject.getPolygon().getVertices()[index] * levelController.UNIT_SCALE;
            }

            slopeShape.set(transformedVertices);

            FixtureDef fixtureDefinition = new FixtureDef();
            fixtureDefinition.shape = slopeShape;
            physicsBody.createFixture(fixtureDefinition);
            slopeShape.dispose();

        }

    }

}


