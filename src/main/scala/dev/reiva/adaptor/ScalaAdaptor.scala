package dev.reiva.adaptor

import org.quiltmc.loader.api.{LanguageAdapter, ModContainer}

class ScalaAdaptor extends LanguageAdapter {
    override def create[T](mod: ModContainer, value: String, `type`: Class[T]): T = {
        try {
            val objectClass = Class.forName(value + "$")
            val moduleField = objectClass.getField("MODULE$")
            val instance = moduleField.get(null).asInstanceOf[T]
            if (instance == null) throw new NullPointerException
            instance
        } catch {
            case _: Exception =>
                println(s"Unable to find ${`type`.getName}$$MODULE$$")
                `type`.getConstructor().newInstance()
        }
    }
}
