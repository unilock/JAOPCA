package thelm.jaopca.api.materials;

import net.minecraftforge.fml.common.eventhandler.Event;

public class MaterialColorEvent extends Event {

	private final IMaterial material;
	private final int color;

	public MaterialColorEvent(IMaterial material, int color) {
		this.material = material;
		this.color = color;
	}

	public IMaterial getMaterial() {
		return material;
	}

	public int getColor() {
		return color;
	}
}
