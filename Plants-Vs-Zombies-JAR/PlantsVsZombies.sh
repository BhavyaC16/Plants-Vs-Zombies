#!/bin/bash
export LIB_PATH=javafx-sdk-11.0.2/lib/
exec java --module-path $LIB_PATH --add-modules javafx.controls,javafx.fxml,javafx.graphics,javafx.media -jar PlantVsZombies.jar
