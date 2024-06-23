package magicbook.gtlitecore.integration.appliedenergistics2.parts;

import com.github.bsideup.jabel.Desugar;

@Desugar
public record PartTypeWithVariant(AE2PartType part, int variant) {

    public PartTypeWithVariant {
        assert part != null;
        assert variant >= 0;
    }

    @Override
    public String toString() {
        return "PartTypeWithVariant{" + "part=" + this.part + ", variant=" + this.variant + "}";
    }
}
