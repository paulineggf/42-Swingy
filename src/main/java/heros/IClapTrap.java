package heros;

public interface IClapTrap
{
        // Getters
        public String   getName();
        public String   getArtefact();
        public int      getLevel();
        public float    getExperience();
        public int      getAttack();
        public int      getDefense();
        public int      getHitPoints();

        // Methods
        public void     getDamage(int damage);
}
