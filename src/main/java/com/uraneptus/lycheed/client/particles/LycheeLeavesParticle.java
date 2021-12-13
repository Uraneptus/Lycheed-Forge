package com.uraneptus.lycheed.client.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LycheeLeavesParticle extends TextureSheetParticle {
    protected final SpriteSet animatedSprite;
    private final float rotSpeed;

    public LycheeLeavesParticle(SpriteSet animatedSprite, ClientLevel world, double posX, double posY, double posZ, double xV, double yV, double zV) {
        super(world, posX, posY, posZ);
        this.animatedSprite = animatedSprite;
        int i = (int) (32.0D / (Math.random() * 0.8D + 0.2D));
        this.lifetime = (int) Math.max((float) i * 1.8F, 2.0F);
        this.quadSize = 0.3F;
        this.rotSpeed = ((float)Math.random() - 0.5F) * 0.1F;
        this.roll = (float)Math.random() * ((float)Math.PI * 2F);
        this.pickSprite(animatedSprite);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
        }else {
            this.move(this.xd, this.yd, this.zd);
            this.yd -= (double)0.002F;
            this.yd = Math.max(this.yd, (double)-0.1F);
            this.oRoll = this.roll;
            this.roll += (float)Math.PI * this.rotSpeed * 1.6F;
            if (this.onGround) {
                this.oRoll = this.roll = 0.0F;
            }
            if (this.level.getFluidState(new BlockPos(this.x, this.y + 0.2, this.z)).isEmpty()) {
                if (this.level.getFluidState(new BlockPos(this.x, this.y - 0.1, this.z)).is(FluidTags.WATER)) {
                    this.onGround = true;
                    this.yd = 0;
                    this.oRoll = this.roll = 0.0F;
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements ParticleProvider<SimpleParticleType> {
        private SpriteSet animatedSprite;

        public Factory(SpriteSet animatedSprite) {
            this.animatedSprite = animatedSprite;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel world, double x, double y, double z, double xV, double yV, double zV) {
            return new LycheeLeavesParticle(this.animatedSprite, world, x, y, z, xV, yV, zV);
        }
    }

}
