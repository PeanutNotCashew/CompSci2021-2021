class Binder{
  public String color;
  public int totalPages;
  public int currentPage;
  public boolean ringsOpen;

  Binder(String selectColor, int selectTotal){
    this.color = selectColor;
    this.totalPages = selectTotal;
    this.currentPage = 1;
    this.ringsOpen = false;
  }

  void nextPage(boolean forwards) {
    if (this.ringsOpen == false) {
      if (forwards == true) {
        if (this.currentPage != this.totalPages) {
          this.currentPage++;
        } else {
          System.out.print("There is no next page");
        }
      } else {
        if (this.currentPage != 0) {
          this.currentPage--;
        } else {
          System.out.print("There is no last page");
        }
      }
    } else {
      System.out.print("Binder rings currently open. Please close before flipping page.");
    }
  }

  void toggleRings() {
    if (this.ringsOpen == false) {
      this.ringsOpen = true;
    } else {
      this.ringsOpen = false;
    }
  }

  void addPages(int pages) {
    if (this.ringsOpen == true) {
      this.totalPages = this.totalPages + pages;
    } else {
      System.out.print("Binder rings currently closed. Please open before adding pages");
    }
  }

  void print() {
    System.out.println(this.color + " binder:");
    System.out.print("Total pgs: ");
    System.out.println(this.totalPages);
    System.out.print("Current pg: ");
    System.out.println(this.currentPage);
    System.out.print("Ring state: ");
    if (this.ringsOpen == false) {
      System.out.println("Closed");
    } else {
      System.out.println("Open");
    }
    System.out.println();
  }

}
