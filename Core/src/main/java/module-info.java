module Core {
    requires Common;
    requires javafx.graphics;
    requires java.desktop;
    requires spring.context;
    opens dk.sdu.mmmi.cbse.main to javafx.graphics, spring.core, spring.beans, spring.context;
    uses dk.sdu.mmmi.cbse.common.services.IGamePluginService;
    uses dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
    uses dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
}


