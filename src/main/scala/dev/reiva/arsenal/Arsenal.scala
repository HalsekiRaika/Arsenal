package dev.reiva.arsenal

import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer
import org.slf4j.{Logger, LoggerFactory}

class Arsenal extends ModInitializer {
    def logger: Logger = LoggerFactory.getLogger("Arsenal")

    override def onInitialize(mod: ModContainer): Unit = {
        logger.info("Hello Scala, from {} Mod!", mod.metadata().name())
    }
}
