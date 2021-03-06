package jp.crafterkina.pipes.common.capability;

import jp.crafterkina.pipes.api.pipe.IItemFlowHandler;
import jp.crafterkina.pipes.api.pipe.IStrategy;
import jp.crafterkina.pipes.api.render.ISpecialRenderer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.FMLCommonHandler;
import org.apache.commons.lang3.NotImplementedException;

/**
 * Created by Kina on 2016/12/19.
 */
public class CapabilityRegister{
    public static void register(){
        register(IItemFlowHandler.class);
        register(IStrategy.IStrategyHandler.class);
        register(IStrategy.StrategySupplier.class);
        if(FMLCommonHandler.instance().getSide().isClient())
            registerOnClient();
    }

    private static void registerOnClient(){
        register(ISpecialRenderer.class);
    }

    private static <T> void register(Class<T> clazz){
        CapabilityManager.INSTANCE.register(clazz, new Capability.IStorage<T>(){
                    @Override
                    public NBTBase writeNBT(Capability<T> capability, T instance, EnumFacing side){
                        throw new NotImplementedException("No default implementation");
                    }

                    @Override
                    public void readNBT(Capability<T> capability, T instance, EnumFacing side, NBTBase nbt){
                        throw new NotImplementedException("No default implementation");
                    }
                },
                () -> {
                    throw new NotImplementedException("No default implementation");
                }
        );
    }
}
