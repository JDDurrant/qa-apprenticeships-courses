package Recap_HandleTree.solution;

public class Tree {
	
	private String name;
	private double height;
	private double growRate;
	TreeType treeType;


	
	public Tree(String name, double height, double growRate, TreeType treeType) {
		this.name = name;
		this.height = height;
		this.growRate = growRate;
		this.treeType = treeType;
	}
	
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	/**
	 * @return the growRate
	 */
	public double getGrowRate() {
		return growRate;
	}
	/**
	 * @param growRate the growRate to set
	 */
	public void setGrowRate(double growRate) {
		this.growRate = growRate;
	}
	/**
	 * @return the treeType
	 */
	public TreeType getTreeType() {
		return treeType;
	}
	/**
	 * @param treeType the treeType to set
	 */
	public void setTreeType(TreeType treeType) {
		this.treeType = treeType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tree [name=" + name + ", height=" + height + ", growRate="
				+ growRate + ", treeType=" + treeType + "]";
	}
	
	
	
	

}
