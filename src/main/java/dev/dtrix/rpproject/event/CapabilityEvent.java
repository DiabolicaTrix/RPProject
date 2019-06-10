package dev.dtrix.rpproject.event;

import dev.dtrix.rpproject.RPProject;
import dev.dtrix.rpproject.capability.ISkill;
import dev.dtrix.rpproject.capability.SkillProvider;
import dev.dtrix.rpproject.capability.SkillStorage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityEvent {

    public static final ResourceLocation CAPABILITY_LOCATION = new ResourceLocation(RPProject.MODID, "skill");

    @SubscribeEvent
    public void onEntityAttach(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof EntityPlayer) {
            event.addCapability(CAPABILITY_LOCATION, new SkillProvider());
        }
    }

    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event) {
        if (!event.getEntityPlayer().world.isRemote && event.isWasDeath()) {
            ISkill oldCap = event.getOriginal().getCapability(SkillStorage.SKILL_CAPABILITY, null);
            ISkill newCap = event.getEntityPlayer().getCapability(SkillStorage.SKILL_CAPABILITY, null);
            oldCap.copyTo(newCap);
        }
    }

    /*@SubscribeEvent
    public void onBreakBlock(BlockEvent.BreakEvent event){
        if(!event.getPlayer().world.isRemote){
            //String blockname = event.getWorld().getBlockState(event.getPos()).getBlock().getRegistryName().getResourcePath();
            //System.out.println(blockname);
            if(event.getExpToDrop() > 0) {
                System.out.println(event.getExpToDrop());
                ISkill skill = event.getPlayer().getCapability(SkillStorage.SKILL_CAPABILITY, null);
                skill.addExperience(event.getExpToDrop() * 10);
                skill.sync((EntityPlayerMP) event.getPlayer());
            }
        }
    }*/

    @SubscribeEvent
    public void onPlayerPickupExperience(PlayerPickupXpEvent event) {
        if (!event.getEntityPlayer().world.isRemote) {
            ISkill cap = event.getEntityPlayer().getCapability(SkillStorage.SKILL_CAPABILITY, null);
            System.out.println("added xp: " + event.getOrb().getXpValue() * 10);
            cap.addExperience(event.getOrb().getXpValue() * 10);
            cap.sync((EntityPlayerMP) event.getEntityPlayer());
        }
    }

}
