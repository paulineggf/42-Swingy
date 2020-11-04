package model.heros;

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

        // Setters
        public void     setExperience(int XP);
        public void     setLevel(int level);


        // Methods
        public void     getDamage(int damage);
}
