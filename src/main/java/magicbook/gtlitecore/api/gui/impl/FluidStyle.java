package magicbook.gtlitecore.api.gui.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import magicbook.gtlitecore.api.gui.IFluidStyle;
import magicbook.gtlitecore.integration.theoneprobe.FluidStackElement;
import mcjty.theoneprobe.apiimpl.styles.ItemStyle;

/**
 * Fluid Style Builder
 *
 * <p>
 *     This class is impl class of the interface {@link IFluidStyle},
 *     just like {@link ItemStyle}, this class create a new style for {@link FluidStackElement}.
 * </p>
 *
 * @since 1.4.28
 */
@Getter @Setter
@Accessors(chain = true, fluent = true)
@NoArgsConstructor
public class FluidStyle implements IFluidStyle {

    private int width = 20;
    private int height = 20;

    public IFluidStyle copy() {
        return new FluidStyle().bounds(this.width, this.height);
    }
}
