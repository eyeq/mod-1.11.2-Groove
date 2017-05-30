package eyeq.groove;

import eyeq.groove.event.GrooveEventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static eyeq.groove.Groove.MOD_ID;

@Mod(modid = MOD_ID, version = "1.0", dependencies = "after:eyeq_util")
public class Groove {
    public static final String MOD_ID = "eyeq_groove";

    @Mod.Instance(MOD_ID)
    public static Groove instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //MinecraftForge.EVENT_BUS.register(new GrooveEventHandler());
    }
}
