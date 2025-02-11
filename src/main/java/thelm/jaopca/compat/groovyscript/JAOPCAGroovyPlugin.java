package thelm.jaopca.compat.groovyscript;

import com.cleanroommc.groovyscript.api.GroovyPlugin;
import com.cleanroommc.groovyscript.api.IGameObjectParser;
import com.cleanroommc.groovyscript.compat.mods.GroovyContainer;
import com.cleanroommc.groovyscript.gameobjects.GameObjectHandler;
import com.cleanroommc.groovyscript.sandbox.expand.ExpansionHelper;

import thelm.jaopca.api.forms.IForm;
import thelm.jaopca.api.materialforms.IMaterialFormInfo;
import thelm.jaopca.api.materials.IMaterial;
import thelm.jaopca.api.modules.IModule;
import thelm.jaopca.api.modules.IModuleData;
import thelm.jaopca.forms.FormHandler;
import thelm.jaopca.materials.MaterialHandler;
import thelm.jaopca.modules.ModuleHandler;

public class JAOPCAGroovyPlugin implements GroovyPlugin {

	@Override
	public String getModId() {
		return "jaopca";
	}

	@Override
	public String getContainerName() {
		return "jaopca";
	}

	@Override
	public void onCompatLoaded(GroovyContainer<?> container) {
		GameObjectHandler.builder("module", IModuleData.class).mod("jaopca").
		addSignature(String.class).
		parser(IGameObjectParser.wrapStringGetter(ModuleHandler::getModuleData)).
		completerOfNamed(ModuleHandler::getModules, IModule::getName);

		GameObjectHandler.builder("form", IForm.class).mod("jaopca").
		addSignature(String.class).
		parser(IGameObjectParser.wrapStringGetter(FormHandler::getForm)).
		completerOfNamed(FormHandler::getForms, IForm::getName);

		GameObjectHandler.builder("material", IMaterial.class).mod("jaopca").
		addSignature(String.class).
		parser(IGameObjectParser.wrapStringGetter(MaterialHandler::getMaterial)).
		completerOfNamed(MaterialHandler::getMaterials, IMaterial::getName);

		ExpansionHelper.mixinClass(IModuleData.class, ModuleDataExpansion.class);
		ExpansionHelper.mixinClass(IForm.class, FormExpansion.class);
		ExpansionHelper.mixinClass(IMaterial.class, MaterialExpansion.class);
		ExpansionHelper.mixinClass(IMaterialFormInfo.class, MaterialFormInfoExpansion.class);
	}
}
