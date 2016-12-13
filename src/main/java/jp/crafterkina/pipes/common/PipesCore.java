package jp.crafterkina.pipes.common;

import jp.crafterkina.pipes.common.recipe.vanilla.CraftManager;
import lombok.Getter;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.InstanceFactory;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static jp.crafterkina.pipes.common.PipesCore.MOD_ID;

@Mod(modid = MOD_ID)
public enum PipesCore {
    INSTANCE;

    public static final String MOD_ID = "jp.crafterkina.pipes";

    @SuppressWarnings("NullableProblems")
    @SidedProxy(clientSide = "jp.crafterkina.pipes.client.ClientProxy", serverSide = "jp.crafterkina.pipes.server.ServerProxy")
    @Getter
    private static CommonProxy proxy;

    @InstanceFactory
    public static PipesCore getInstance(){
        return INSTANCE;
    }

    @EventHandler
    private void preInit(FMLPreInitializationEvent event){
        CraftManager.INSTANCE.register();
    }
}
